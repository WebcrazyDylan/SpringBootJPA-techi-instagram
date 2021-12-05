package cf.dylan.techiinstagram.Service;

import java.util.ArrayList;

import cf.dylan.techiinstagram.Entity.Status;
import cf.dylan.techiinstagram.Repository.StatusRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StatusService {

	private final StatusRepo statusRepo;
	private final UserService userService;
	
	public Status submitDataIntoDB(Status status) {
		return statusRepo.save(status);
	}
	
	public ArrayList<Status> retrieveStatus(){
		
		ArrayList<Status> statusList=statusRepo.findAll();

		for (Status statusItem : statusList) {
			statusItem.setUserName(
					userService.displayUserMetaData(statusItem.getUserId()).getUserName());
		}
		
		return statusList;
	}
}
