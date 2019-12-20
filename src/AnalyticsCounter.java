
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class AnalyticsCounter {
	private Map<String, Integer> sympt;
	private  ISymptomReader rsdf ;
	public AnalyticsCounter(String sympt) {
		 rsdf = new ReadSymptomDataFromFile(sympt) ;
		
	}
	
	public void OutputFile()  {
	   try { FileWriter fstream = new FileWriter("result.txt");
	    BufferedWriter out = new BufferedWriter(fstream);
	    
		this.sympt.entrySet()
		  .stream()
		  .sorted(Map.Entry.<String,Integer>comparingByKey())
		  .forEach(pair -> {
			try {
				out.write(pair.getKey() + " = " + pair.getValue() + "\n");
				out.flush();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		});
		
	   } catch (IOException e) {
		   
	   e.printStackTrace();}
	}
	public void process() {
		this.sympt=rsdf.GetSymptoms();
	} 
	public static void main(String args[]) throws Exception {
		AnalyticsCounter Otpf = new AnalyticsCounter("symptoms.txt");
		Otpf.process();
		Otpf.OutputFile();
		 }

	}
	