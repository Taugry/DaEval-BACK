package fr.dawan.miseensituation.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.dawan.miseensituation.dto.DtoTools;
import fr.dawan.miseensituation.dto.LoginDto;
import fr.dawan.miseensituation.dto.LoginResponseDto;
import fr.dawan.miseensituation.dto.UtilisateurDto;
import fr.dawan.miseensituation.entities.Utilisateur;
import fr.dawan.miseensituation.repositories.UtilisateurRepository;
import fr.dawan.miseensituation.tools.HashTools;
import fr.dawan.miseensituation.tools.JwtTokenUtil;
import fr.dawan.miseensituation.tools.TokenSaver;

@Service
@Transactional
public class UtilisateurServiceImpl extends GenericServiceImpl<Utilisateur,UtilisateurDto> implements UtilisateurService{

	public UtilisateurServiceImpl(UtilisateurRepository repo) {
		super(repo, Utilisateur.class, UtilisateurDto.class);
	}
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UtilisateurRepository URepo;
	
	@Autowired
	private GenericService<UtilisateurDto> genericService;

	@Override
	public List<UtilisateurDto> getAllPages(int page, int max, String search) {
				List<Utilisateur> users = URepo.findAllByFirstNameContainingOrLastNameContainingOrEmailContaining(search,
						search, search, PageRequest.of(page, max)).get().collect(Collectors.toList());

				List<UtilisateurDto> result = new ArrayList<UtilisateurDto>();
				for (Utilisateur u : users) {
					result.add(DtoTools.convert(u, UtilisateurDto.class));
				}
				return result;
	}

	@Override
	public UtilisateurDto SetUser(UtilisateurDto uDto) throws Exception {
		uDto.setPassword(HashTools.hashSHA512(uDto.getPassword()));
		uDto.setActive(true);
		return uDto;
	}
	
	@Override
	public UtilisateurDto UpdateUser(UtilisateurDto uDto) throws Exception {
		UtilisateurDto uDB = genericService.GenericGetById(uDto.getId());
		
		if(uDto.getPassword() == "" ) {
			uDto.setPassword(uDB.getPassword());
			return uDto;
		}else if(uDB.getPassword().equals(HashTools.hashSHA512(uDto.getPassword()))){
			System.out.println(uDB.getPassword().equals(HashTools.hashSHA512(uDto.getPassword())));
			return uDto;
		}else {
			uDto.setPassword(HashTools.hashSHA512(uDto.getPassword()));
		}
		return uDto;
	}

	@Override
	public LoginResponseDto checkLogin(LoginDto loginDto) throws Exception {
		Utilisateur u = URepo.findByEmail(loginDto.getEmail());		
		
		if (u != null && u.getPassword().equals(HashTools.hashSHA512(loginDto.getPassword()))) {
			LoginResponseDto result = DtoTools.convert(u, LoginResponseDto.class);
						
			// generate JWT TOKEN
			Map<String, Object> claims = new HashMap<String, Object>();
			claims.put("user_id", u.getId());
			claims.put("user_name", u.getFirstName());
			claims.put("user_email", u.getEmail());
			claims.put("user_role", u.getRole());

			String token = jwtTokenUtil.doGenerateToken(claims, loginDto.getEmail());
			TokenSaver.tokensByEmail.put(u.getEmail(), token);
			result.setToken(token);		
			
			return result;
		} else
			throw new Exception("Error : invalid credentials !");
	}

	@Override
	public int CountUser() {
		return URepo.CountUserQuery();
	}

	@Override
	public long CountUserwithsearch(String search) {
		return URepo.countByFirstNameContainingOrLastNameContainingOrEmailContaining
				(search, search, search);
		//return URepo.countfinal(search, search, search);
	}
}
