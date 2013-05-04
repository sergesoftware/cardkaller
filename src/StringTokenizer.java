import java.util.Vector;
// Basic string tokenizer, this will tokenize the input string to make it easier to deal with.
public class StringTokenizer
{
        //globals
        private int index = 0;
        private String[] data;

//constructor
public StringTokenizer(String input, String token_)
{
       data = split(input, token_);
}

// returns the next element in the tokenized list
public String nextElement()
{
	String returnValue = "";
	if(index < data.length)
		{
		returnValue = data[index];
		}
	index++;
    return returnValue;
}

// returns true if there are more elements in the list
public boolean hasMoreElements()
{
return index < data.length;
}

public static String[] split(String inString, String delimeter) {
	String[] retAr = new String[0];
	boolean finished = false;
	try {
		Vector vec = new Vector();
		int indexA = 0;
		int indexB = inString.indexOf(delimeter);

		while (indexB != -1) {
			if (indexB >= indexA)
				vec.addElement(new String(inString
						.substring(indexA, indexB)));
			indexA = indexB + delimeter.length();
			indexB = inString.indexOf(delimeter, indexA);
		}
		vec.addElement(new String(inString.substring(indexA, inString
				.length())));
		retAr = new String[vec.size()];
		for (int i = 0; i < vec.size(); i++) {
			retAr[i] = vec.elementAt(i).toString();
		}
	} catch (Exception e) {
		//sysout

	}
	return retAr;
}
}
