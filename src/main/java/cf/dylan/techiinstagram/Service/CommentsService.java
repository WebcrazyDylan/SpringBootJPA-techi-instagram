package cf.dylan.techiinstagram.Service;

import java.util.ArrayList;

import cf.dylan.techiinstagram.Entity.Comments;
import cf.dylan.techiinstagram.Repository.CommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentsService {

	private final CommentRepo commentRepo;
	private final UserService userService;
	
	public Comments submitCommentToDB(Comments comment) {
		return commentRepo.save(comment);
	}
	
	public ArrayList<Comments> getAllCommentsForDB(String postId){
		ArrayList<Comments> commentList=commentRepo.findAllByPostId(postId);

		for (Comments commentItem : commentList) {
			commentItem.setUserName(
					userService.displayUserMetaData(commentItem.getUserId()).getUserName());
		}
		
		return commentList;
	}
}
