package mx.uam.ayd.sgp.persistencia;

public class DatabaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	Exception m_realException;

	DatabaseException(String msg, Exception ex)
	{
		super(msg);
		m_realException = ex;
	}
	
	public Exception getRealException()
	{
		return m_realException;
	}
	
}
