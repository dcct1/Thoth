package dcct1.Thoth.menu;
/**
 * Date March 2018
 * Author DCCT1
 * Lab code copied in here
 */

public	class FactoryException extends Exception
{
				public	FactoryException()	{}
				
		
				
				public	FactoryException(String	s)
				{
					super(s);
				}
				
				
				public	FactoryException(Exception	e)
				{
						super(e.toString());
				}
}