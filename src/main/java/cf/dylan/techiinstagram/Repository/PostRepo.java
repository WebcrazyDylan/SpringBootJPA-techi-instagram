package cf.dylan.techiinstagram.Repository;

import java.util.ArrayList;

import cf.dylan.techiinstagram.Entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepo extends CrudRepository<Post, Integer> {

	Post save(Post post);
	ArrayList<Post> findAll();
	
}
