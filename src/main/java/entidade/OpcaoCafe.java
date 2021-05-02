package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OPCAOCAFE")
public class OpcaoCafe {
	
	@Id
	@Column(name="OPCAFE", nullable=false)
	private String opcafe;

	public String getOpcafe() {
		return opcafe;
	}

	public void setOpcafe(String opcafe) {
		this.opcafe = opcafe;
	}	
	

}
