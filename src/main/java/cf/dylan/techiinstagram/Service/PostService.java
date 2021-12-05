package cf.dylan.techiinstagram.Service;

import java.util.ArrayList;

import cf.dylan.techiinstagram.Entity.Post;
import cf.dylan.techiinstagram.Repository.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepo postRepo;
	private final UserService userService;
	
	public Post submitPostToDataBase(Post post) {
		return postRepo.save(post);
	}
	
	public ArrayList<Post> retrievedPostFromDB(){

		ArrayList<Post> postList=postRepo.findAll();

		for (Post postItem : postList) {
			postItem.setUserName(userService.displayUserMetaData(postItem.getUserId()).getUserName());
		}
		postList.sort((a, b) -> b.getId() - a.getId());
		//Collections.sort(postList,(a,b)->b.getId()-a.getId());
		return postList;
	}
	
}
