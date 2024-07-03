package dept;

import java.util.List;

public interface DeptDAO {
	int insert(DeptDTO user) ;
	int delete(String id) ;
	List<DeptDTO> select();
}

