package edu.hhuc.course_selection.service;
import edu.hhuc.course_selection.repository.StudentLoginRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class StudentLoginService implements UserDetailsService{
    @Resource
    StudentLoginRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserDetails details = repository.findStudentLoginByUsername(username);
        if(details == null){
            throw new UsernameNotFoundException("账户"+username+"不存在");
        }
        
        return repository.findStudentLoginByUsername(username);
    }
}
