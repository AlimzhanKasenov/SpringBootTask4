package Task4.SpringBootTask4.BIN;


import Task4.SpringBootTask4.model.applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface applicationRepos extends JpaRepository<applications, Long> {
    List<applications> findAllByOrderByHandledDesc();
    //findAllByIdNullOrderByHandledDesc

}