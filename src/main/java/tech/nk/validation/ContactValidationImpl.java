package tech.nk.validation;

public class ContactValidationImpl implements ContactValidation {

	
	private String result;
	@Override
	public String contactValidation(String name, String email, String subject, String message) {
		
		try
		{
			//name 
			int name_len=name.length();
			int email_len=email.length();
			int subject_len=subject.length();
			int message_len=message.length();
			
			if(name_len<2 || name_len>50)
			{
				result="INVALID NAME LENGTH";
			}
			else if(email_len<5 || email_len>50 || !email.contains("@"))
			{
				result="INVALID EMAIL";
			}
			else if(subject_len<10 || subject_len>70 )
			{
				result="INVALID SUBJECT";
			}
			else if(message_len<10 || message_len>500 )
			{
				result="INVALID MESSAGE";
			}
			else
			{
				result="VALID";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result="SOMETHING WENT WRONG";
		}
		
		return result;
	}

}
