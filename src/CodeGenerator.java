/** CodeGenerator
 *
 * generates the essential methods of an object class
 * declares the variables read from a text file
 * methods generated include:
 * 		constructor, copy constructor
 * 		accessors/getters
 * 		mutators/setters
 * 		toString()
 *
 * @author Rashad Saab
 */
import java.io.*;
import java.util.*;

public class CodeGenerator {
	private PrintStream code;
	private String className;
	private Variable[] myVariables;
	private File f;

	/**
	 * this method reads the input data and stores them in a variables array
	 * @param 	fileName
	 * @return	array of variables
	 * @throws 	FileNotFoundException
	 */
	public CodeGenerator(String fileName) throws FileNotFoundException
	{
		myVariables=new Variable[getNbLines(fileName)-1]; // -1 since the first line is not included in the myVariables array
		File file=new File(fileName);
		Scanner input=new Scanner(file);
		className=input.nextLine();
		int i=0;
		while(input.hasNext())
		{
			myVariables[i]=new Variable(input.next(), input.next());
			i++;
		}
		input.close();
		f=new File(className+".java");
		code=new PrintStream(f);
	}
	
	public void generateJavaCode()
	{
		beginClass();
		generateConstructor();
		generateCopyConstructor();
		generateAccessorsAndMutators();
		this.generateToString();
		endClass();
		code.close();
	}

	private int getNbLines(String fileName) throws FileNotFoundException
	{
		File file=new File(fileName);
		Scanner input=new Scanner(file);
		int count=0;
		while(input.hasNextLine())
		{
			input.nextLine();
			count++;
		}
		input.close();
		return count;
	}

	public void beginClass()
	{
		code.println("public class "+this.className+ "{");
		for(int i=0; i<myVariables.length; i++)
		{
			code.println("\tprivate "+myVariables[i].getType()+" "+myVariables[i].getName()+";");
		}
		code.println();
	}

	public void generateConstructor()
	{
		code.println("\t/**\n\t* Constructor for objects of class"+className+"\n\t*/");
		code.println("\tpublic "+className+"() {\n\t}");
		code.println();
	}

	public void generateCopyConstructor(){
		code.println("\t/**\n\t* copy constructor"+"\n\t*/");
		code.println("\tpublic "+className+"("+className+" s) {");
		for(int i=0; i<myVariables.length; i++){
			code.println("\t\tthis."+myVariables[i].getName()+"=s."+myVariables[i].getName()+";");
		}
		code.println("\t}");
		code.println();
	}

	public void generateAccessorsAndMutators()
	{
		for(int i=0;i< myVariables.length;i++)
		{
			//method comments
			code.println("\t/**\n\t* returns the "+myVariables[i].getName()+" of the "+className+"\n\t*/");
			//set method name format
			String str=myVariables[i].getName();
			String editedName=str.substring(0, 1).toUpperCase()+str.substring(1,str.length());;
			code.println("\tpublic "+myVariables[i].getType()+" get"+editedName+"() {");
			code.println("\t\treturn "+myVariables[i].getName()+";");
			code.println("\t}");
			code.println();
			generateMutators(myVariables[i], editedName);
		}
		code.println();
	}

	public void generateMutators(Variable var, String editedName)
	{
		//method comments
		code.println("\t/**\n\t* mutator method to set the "+var.getName()+" of the "+className+"\n\t*@param "+var.getType()+" the value of type "+var.getType()+"\n\t*/");
		//method declaration
		code.println("\tpublic void set"+editedName+"("+var.getType()+" "+var.getName()+") {");
		//method body
		code.println("\t\tthis."+var.getName()+"="+var.getName()+";");
		code.println("\t}");

		code.println();
	}

	public void generateToString()
	{
		//method comments
		code.println("\t/**\n\t* Returns a string object representing this "+className+" value.\n\t* The result is a string of "+myVariables.length+" line(s) where each line is in turn\n\t* the string representation of the corresponding instance field.\n\t* @return a string representation of this object.\n\t*/");
		//method declaration
		code.println("\tpublic String toString() {");
		//method body
		code.println("\t\tString s= \"\";");
		for(int i=0; i<myVariables.length; i++){
			code.println("\t\ts+= \""+"\\"+"n"+ myVariables[i].getName()+" = \" + "+myVariables[i].getName()+";");
		}
		code.println("\t\treturn "+"s;\n\t}");
		code.println();
	}

	public void endClass(){
		code.println("}");
	}
	
	public void closePrintStream()
	{
		code.close();
	}
	
	public boolean deleteGeneratedJavaFile()
	{
		code.close();
		return f.delete();
	}
	
	public String getClassName()
	{
		return f.getName();
	}

	/* test main*/
	public static void main(String[] args) throws FileNotFoundException
	{
		CodeGenerator myCode=new CodeGenerator("test_1.txt");
		myCode.generateJavaCode();
		System.out.println("complete");
	}
}