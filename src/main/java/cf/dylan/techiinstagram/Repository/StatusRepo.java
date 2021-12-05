package cf.dylan.techiinstagram.Repository;

import java.util.ArrayList;

import cf.dylan.techiinstagram.Entity.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StatusRepo extends CrudRepository<Status, Integer>{

	Status save(Status save);
	ArrayList<Status> findAll();
}
