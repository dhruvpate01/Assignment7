import java.io.DataInput;

//Class definition
public class StudentListings {
		//Class Variables declarations
		private String StuName;
		private int Id_number;
		private double GPA;
	//constructor without parameters
	public StudentListings()
	{
		StuName="abc";
		Id_number=1234;
		GPA=0.0;
	}
	//Method to string definition
	public String toString()
	{
		return("Name is " + StuName +"\nId number is " + GPA + "\n");
	}
	// method definition
	public StudentListings deepCopy()
	{
		StudentListings clone = new StudentListings();
		return clone;
	}
	//method compareTo() definition
	public int compareTo(String targetKey)
	{
		return(StuName.compareTo(targetKey));
	}
	//method input definition
	public void input()
	{
		//StuName = JOptionPane.showInputdialog("Enter the name");
        System.out.println("Enter student Name");
        String StuName = DataInput.next();
        System.out.println("Enter student Number");
        int Id_number = DataInput.nextInt();
        System.out.println("Enter the GPA");
        double GPA = DataInput.nextDouble();
	}
	// Driver main method
	public static void main(String[] args) {
	StudentListings classlist = new StudentListings();

	classlist.input();
	System.out.println(classlist.toString());
	int flag=classlist.compareTo("Aisha");
	classlist.deepCopy();
	if(flag==0)
	{
		System.out.println("Aisha is there in the list");
	}
	else
		System.out.println("Aisha is not there in the list");
	}
}


