

import java.util.ArrayList;

public class BootCampAdministration {

	//Create a private ArrayList with object of BootCampCandidates with name anArrayListOfBootCamps
	private ArrayList<BootCampCandidates> anArrayListOfBootCamps;

	
	//Create a constructor which receives an array with BootCampCandidate objects and 
	//initializes the anArrayListOfBootCamps ArrayList by adding all BootCampCandidate array's
	//elements in the the nArrayListOfBootCamps
	public BootCampAdministration() {}
	public BootCampAdministration(BootCampCandidates[] anArrayOfBootCampCandidates) {
		this.anArrayListOfBootCamps = new ArrayList<>();
        for (int i=0; i<anArrayOfBootCampCandidates.length; ++i)
            this.anArrayListOfBootCamps.add(anArrayOfBootCampCandidates[i]);
	}

	
	//Create setters and getters for BootCampAdministration
	public ArrayList<BootCampCandidates> getAnArrayListOfBootCamps() {
		return anArrayListOfBootCamps;
	}
	public void setAnArrayListOfBootCamps(ArrayList<BootCampCandidates> anArrayListOfBootCamps) {
		this.anArrayListOfBootCamps = anArrayListOfBootCamps;
	}	

	//create an int method that returns the size of anArrayListOfBootCamps
	public int sizeOf() {
		return this.anArrayListOfBootCamps.size();
	}
	
	//Create a method that adds a new BootCampCandidate inside the ArrayList
	public void addBootCampCandidate (BootCampCandidates candidate) {
		this.anArrayListOfBootCamps.add(candidate);
		System.out.println("Candidate " +candidate.getName() +" " +candidate.getSurname() +" added to the list.\n");
		
	}
	
	//Create a method that removes a candidate by name and returns true if found or false if not
	//HINT: you have to use get() to get the object and equals to compare it
	public boolean removeBootCampCandidate (String name) {
		for (int i=0; i<anArrayListOfBootCamps.size(); ++i) {
            if (this.anArrayListOfBootCamps.get(i).getName().equals(name)) {
                this.anArrayListOfBootCamps.remove(i);
                System.out.println("Candidate " +name +" removed from list.\n");
                return true;
            }
        } 
		System.out.println("Candidate " +name +" not found.\n");
		return false;
	}

	//Create a method to search for a boot camp member by surname and returns a string with its information
	// if it's found and null if it's not found
	public void findBootCampCandidate(String surname){
		String found = null;
		for (BootCampCandidates candidate : anArrayListOfBootCamps){
			if (candidate.getSurname().equals(surname)){
				found = candidate.toString();
				System.out.println(found +"\n");
			}
		}
		if (found.equals(null)){
			System.out.println("Candidate " +surname +" not found.\n");
		}
	}
		
	//Create a method that can change a bootcampers age by having as input its name and surname
	public void changeAge (String name, String surname, int newAge) {
		String found = null;
		for (BootCampCandidates candidate : anArrayListOfBootCamps){
			if (candidate.getSurname().equals(surname) && candidate.getName().equals(name)){
				candidate.setAge(newAge);
				found = name +" " +surname +"'s age changed to " +newAge +"\n";
				System.out.println(found);
			}
		}
		if (found.equals(null)){
			System.out.println("Candidate" +surname +" not found.\n");
		}
	}
	
	public void printArrayListOfBootCamps (){
		System.out.println("                   *** Candidate List ***");
		System.out.println("===============================================================");
		for (BootCampCandidates candidate : anArrayListOfBootCamps){
			System.out.println(candidate.toString());
		}
		System.out.println("===============================================================");
		System.out.println();
	}
	
}
