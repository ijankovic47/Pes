package konami.pes.dao;

import konami.pes.domain.Operator;

public interface OperatorDao {

	public Operator getOperatorByUsername(String username);
}
