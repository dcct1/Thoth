package dcct1.Thoth.menu;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;



public class Factory {

	private static Factory theFactory = null;
	
	
	//constructor
	
	private Factory() {}

	
	
	public static Factory getFactory()
	
	{
		if ( theFactory == null)
			
		{
			
			theFactory = new Factory();
		}
		return theFactory;
	}

	public static void removeFactory()
	{
		
		if (theFactory != null)
			theFactory = null;
		
	}

	public Object getObject(String className)
			
	throws FactoryException
	
	{
		
		Object[] parameters = new Object[0];
		String[] parameterNames = new String[0];
		return createObject(className, parameters, parameterNames);
	}
	
	public Object	getObject(	String	className,Object parameter,String parameterName)
	
	throws FactoryException
		{
		Object[]	parameters	=	new Object[1];										
		parameters[0]	=	parameter;																				
		String[]	parameterNames	=	new String[1];
		parameterNames[0]	=	parameterName;
		return	createObject(className,	parameters,	parameterNames);
		}	
	
	public Object getObject(String className, Object[ parameters, String[] parameterNames);
	throws FactoryException
	
	{
		return createObject(className, parameters, parameterNames );
	}
	public Object	createObject(	String	className,
			Object[]	parameters,
			String[]	parameterClassNames	)
	
	throws	FactoryException
		{
				int	x	=	0;									//	counters
				Class	theClass;				//	represents	a	classes	and	interfaces	in	a	running	java	application
										//	see	if	class	exists	and	can	be	initialised

				try
					{
					theClass	=	Class.forName(className);				//causes	the	class	to	be	initilised
						}
					catch	(ClassNotFoundException	e)
					{
						throw new	FactoryException(e);
					}
		Constructor	con;	
		
		Class[]	classParams	=	new	Class[parameters.length];
		try
		{
						for	(x	=	0;	x	<	parameters.length;	x++)
						{
										classParams[x]	=	Class.forName(parameterClassNames[x]);
						}
		}
		catch	(ClassNotFoundException	e)
		{
						throw new	FactoryException(e);
		}
		//	look	for	a	constructor	matching	the	parameter	signature
		try
		{
						con	=	theClass.getConstructor(classParams);
		}
		catch	(NoSuchMethodException	e)
		{
						throw new	FactoryException(e);
		}
		catch	(SecurityException	e)
		{
						throw new	FactoryException(e);
		}
		//	instanciate	the	object	using	the	constructor
		try
		{
						return	(Object)con.newInstance(parameters);
		}
		catch	(InstantiationException	e)
		{
						throw new	FactoryException(e);
		}
		catch	(IllegalAccessException	e)
		{
						throw new	FactoryException(e);
		}
		catch	(IllegalArgumentException	e)
		{
						throw new	FactoryException(e);
		}
		catch	(InvocationTargetException	e)
		{
						e.getTargetException().getMessage();
						e.getTargetException().printStackTrace();
						throw new	FactoryException(e);
		}
		
		}
	
}
	

