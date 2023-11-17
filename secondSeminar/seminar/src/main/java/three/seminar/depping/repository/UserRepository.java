package three.seminar.depping.repository;

import org.springframework.stereotype.Repository;
import three.seminar.depping.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private static final Map<Integer, User> handong = new HashMap<>();

    public User save(User user){
        handong.put(user.getStuNum(), user);
        return user;
    }

    public User findById(Integer stuNumber){
        return handong.get(stuNumber);
    }

    public List<User> findAll(){
        return new ArrayList<>(handong.values());
    }

    public void update(Integer id, User updateParams){
        User findUser = findById(id);
        findUser.setStuName(updateParams.getStuName());
        findUser.setStuNum(updateParams.getStuNum());
    }

    public void delete(Integer id){
        handong.remove(id);
    }
}
