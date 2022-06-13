package ssp_practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import org.eclipse.jetty.server.*;

public class ssp_practice {
	static String rootPath = ".\\INPUT";
	final static int BUFFER_SIZE = 4096;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//File IO
		File directory = new File(".\\INPUT");
		File[] fList = directory.listFiles();
		
		
		for(File file:fList) {
			if(file.isDirectory()) {
				System.out.println("["+file.getName()+"]");
			}else {
				System.out.println(file.getName());
			}
		}
		
		FileSearchAll(directory.getPath());
		
		File destFolder = new File("./OUTPUT");
		if(!destFolder.exists()) {
			destFolder.mkdirs();
		}
		
		//ArrayList
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("C");
		al.add("A");
		al.add("B");
		
	
		Iterator<String> itr = al.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		//ArrayList 정렬
		Collections.sort(al);
		
		for(String s:al) {
			System.out.println(s);
		}
		
		//Comparator
		Comparator<String> co = new Comparator<String>() {
			public int compare(String o1, String o2) {
				return(o1.compareTo(o2));
			}
		};
		
		Collections.sort(al, co);
		itr = al.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		Collections.sort(al, (g2, g1) -> g1.compareTo(g2));
		itr = al.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		//Map
		String key="key", value="value";
		HashMap<String, String> m = new HashMap<String, String>();
		m.put(key, value);
		m.put("aA","ABCD");
		
		for(String kye: m.keySet()) {
			System.out.println(m.get(kye));
		}
		
		//Queue
		Queue<String> numberQ = new LinkedList<>();
		numberQ.add("one");
		numberQ.add("two");
		numberQ.add("three");
		
		for(String number:numberQ) {
			System.out.println(number);
		}
		
		System.out.println(numberQ.peek());
		System.out.println(numberQ.peek());
		System.out.println(numberQ.poll());
		System.out.println(numberQ.peek());
		
		System.out.println(numberQ.contains("three"));
		System.out.println(numberQ.size());
		
		/*
		//ArrayList 실습
		try {
			ArrayList<Grade> scoreList = new ArrayList<Grade>();
			
			BufferedReader filebr = new BufferedReader(new FileReader("List_Sample.txt"));
			String str;
			while((str = filebr.readLine()) != null) {
				String score[]=str.split("\t");
				
				scoreList.add(new Grade(score[0],Integer.parseInt(score[1]), Integer.parseInt(score[2]), Integer.parseInt(score[3])));
			}
			
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command = br.readLine();
		
			while(!command.equals("QUIT")) {
				switch(command) {
				case "PRINT":
					Collections.sort(scoreList, (g1, g2)->g1.getName().compareTo(g2.getName()));
					Iterator<Grade> it = scoreList.iterator();
					while(it.hasNext()) {
						Grade g = it.next();
						System.out.println(g.getName()+"\t"+g.getKorean()+"\t"+g.getEnglish()+"\t"+g.getMath());
					}
					break;
				case "KOREAN":
					Collections.sort(scoreList, (g1, g2) -> (g1.getKorean()-g2.getKorean()) == 0 ? g1.getName().compareTo(g2.getName()) : g2.getKorean()-g1.getKorean());
					Iterator<Grade> itk = scoreList.iterator();
					while(itk.hasNext()) {
						Grade g = itk.next();
						System.out.println(g.getName()+"\t"+g.getKorean()+"\t"+g.getEnglish()+"\t"+g.getMath());
					}
					break;
				case "ENGLISH":
					break;
				case "MATH":
					break;
				}
				
				br = new BufferedReader(new InputStreamReader(System.in));
				command = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//외부 프로세스 실행
		String output = getProcessOutput(Arrays.asList("add_2sec.exe", "2", "3"));
		System.out.println(output);
		*/
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName()+"is running");
			}
		});
		
		t1.start();
		
		Runnable taskR = () ->{
			System.out.println(Thread.currentThread().getName()+"is running");
		};
		new Thread(taskR).start();
		
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+"is running");
		}).start();
	

		
		Thread t5 = new Thread(() -> {
			for(int i=0; i<10; i++) {
				System.out.println("["+Thread.currentThread().getName()+"] "+i);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		Thread t6 = new Thread(() -> {
			for(int i=0; i<10; i++) {
				System.out.println("["+Thread.currentThread().getName()+"] "+i);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t5.start();
		t6.start();
		for(int i=0; i<10; i++) {
			System.out.println("[Main]"+i);
			Thread.sleep(10);
		}
		
		t5.join();
		t6.join();
		
		//JSON
		JsonElement jsonElement = JsonParser.parseString("{\"key\":\"value\"}");
		System.out.println(jsonElement.toString());
		
		
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("name", "spiderman");
		jsonObj.addProperty("age", 45);
		jsonObj.addProperty("married", true);
		
		JsonArray jsonArr = new JsonArray();
		jsonArr.add("martial art");
		jsonArr.add("gun");
		jsonObj.add("specialty", jsonArr);
		
		
		JsonObject jsonObj2 = new JsonObject();
		jsonObj2.addProperty("1st", "done");
		jsonObj2.addProperty("2nd", "expected");
		jsonObj2.add("3rd", null);
		jsonObj.add("vaccine", jsonObj2);
		
		JsonArray jsonArr2 = new JsonArray();
		JsonObject jsonObj3 = new JsonObject();
		jsonObj3.addProperty("name", "spiderboy");
		jsonObj3.addProperty("age", 10);
		jsonArr2.add(jsonObj3);
		
		JsonObject jsonObj4 = new JsonObject();
		jsonObj4.addProperty("name", "spidergirl");
		jsonObj4.addProperty("age", 8);
		jsonArr2.add(jsonObj4);
		jsonObj.add("children", jsonArr2);
		
		jsonObj.add("address", null);
		
		try(Writer writer = new FileWriter("sample.json")){
			Gson gson = new GsonBuilder().serializeNulls().create();
			gson.toJson(jsonObj, writer);
			
		}
		
		System.out.println(jsonObj.toString());
		
		String jsonPath = "sample.json";
		
		Gson gson = new Gson();
		JsonReader jr = new JsonReader(new FileReader(jsonPath));
		JsonObject jo = gson.fromJson(jr, JsonObject.class);
		
		System.out.println("name(age) :"+jo.get("children").getAsJsonArray().get(0).getAsJsonObject().get("name").getAsString()+"("+
				jo.get("children").getAsJsonArray().get(0).getAsJsonObject().get("age").getAsInt()+")");
		
		for(String jsonKey:jo.keySet()) {
			System.out.println("Key: "+jsonKey+" / Value Type : "+jo.get(jsonKey).isJsonArray());
		}
		
		Server server = new Server();
	}
	
	public static String getProcessOutput(List<String> cmdList) throws IOException {
		ProcessBuilder builder = new ProcessBuilder(cmdList);
		Process process = builder.start();
		
		InputStream psout = process.getInputStream();
		byte[] buffer = new byte[1024];
		
		psout.read(buffer);
		return(new String(buffer));
		
	}
	
	public static void FileSearchAll(String path) {
		File directory = new File(path);
		File[] fList = directory.listFiles();
		
		String partPath;
		String outputPath=".\\OUTPUT";
		
		for(File file : fList) {
			if(file.isDirectory()) {
				//System.out.println("["+file.getName()+"]");
				
				FileSearchAll(file.getPath());
			}else {
				partPath = path.substring(rootPath.length());
				System.out.println("."+partPath+"\\"+file.getName()+": "+file.length()+"bytes");
				
				if(file.length()>3072) {
					try {
						File outFile = new File(outputPath+partPath);
						if(!outFile.exists()) {
							outFile.mkdirs();
						}
						InputStream input = new FileInputStream(file);
					
						OutputStream output = new FileOutputStream(outputPath+partPath+"\\"+file.getName());
						
						byte[] buffer = new byte[BUFFER_SIZE];
						int readLen;
						while((readLen=input.read(buffer)) != -1) {
							output.write(buffer, 0, readLen);
						}
						
						input.close();
						output.close();
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}
	}

}
