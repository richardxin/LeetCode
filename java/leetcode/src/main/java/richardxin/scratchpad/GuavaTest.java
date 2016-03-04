package richardxin.scratchpad;

import java.util.List;

import com.google.gson.Gson;

public class GuavaTest {
	
	public static void testReflection(){
        String expectedResponse = "["
        		+ "{'id':'23a58453-6300-3c36-8a59-2365705cb0e7','title':'Point Counterpoint: Lee Marvin and Michelle Triola','url':'http://screen.yahoo.com/point-counterpoint-lee-marvin-michelle-000000157.html','description':'Dan Aykroyd and Jane Curtin debate relationships in this classic Weekend Update sketch.'},"
        		+ "{'id':'b1f42585-885f-31b9-8ee1-4b66843d3b9e','title':'The French Chef','url':'http://screen.yahoo.com/french-chef-000000398.html','description':'Dan Aykroyd performs his Julia Child impression with a slice of thumb.'},"
        		+ "{'id':'d59f37a0-67c7-3d7d-ab85-ecade6ecc91c','title':'Steve Martin: Memories Monologue','url':'http://screen.yahoo.com/steve-martin-memories-monologue-000000722.html','description':'Steve Martin remembers when Belushi or was it Aykroyd...'},"
        		+ "{'id':'4e330744-8bf4-39e5-9c75-4f167b456669','title':'Samurai Night Fever','url':'http://screen.yahoo.com/samurai-night-fever-000000252.html','description':'John Belushi takes a stab at Saturday Night Fever in this continuation on his samurai sketches.'},"
        		+ "{'id':'69c7fb58-4e61-3891-8976-03391f21d51d','title':'Bad Conceptual Theater','url':'http://screen.yahoo.com/bad-conceptual-theater-000000312.html','description':'Leonard Pinth-Garnell presents a play written by an infinite number of monkeys.'},"
        		+ "{'id':'941b5c91-24d1-34a8-9d06-d01a95cec5b1','title':'Dole, Clinton Point, Counterpoint Cold Open','url':'http://screen.yahoo.com/dole-clinton-point-counterpoint-cold-000000826.html','description':'Bill Clinton and Bob Dole with Point/Counterpoint on 60 Minutes.'},"
        		+ "{'id':'3a7e32df-ec5b-3e0b-a292-47e5c34b601d','title':'Star Trek: The Last Voyage of the Starship Enterprise','url':'http://screen.yahoo.com/star-trek-last-voyage-starship-000000229.html','description':'Join James T. Kirk for the final voyage of the Starship Enterprise.'},"
        		+ "{'id':'0ae51c57-4d7c-3f31-a57e-bd2b6ea561fe','title':'Plain Talk','url':'http://screen.yahoo.com/plain-talk-000000679.html','description':'A talk show that no one really understands.'},"
        		+ "{'id':'f8133f1c-3887-3921-92e0-31b8880e5783','title':'E Buzz Millers Art Classics','url':'http://screen.yahoo.com/e-buzz-millers-art-classics-000000581.html','description':'Give yourself an art education with E. Buzz Miller and friend.'},"
        		+ "{'id':'85c40330-6575-3491-b26e-eeff3d7f6f87','title':'The Corrida','url':'http://screen.yahoo.com/corrida-000000285.html','description':'A fine driving machine for a fine Spanish actor.'}"
        		+ "]";
        java.lang.reflect.Type listType = new com.google.common.reflect.TypeToken<List<Result>>() {}.getType();
        Gson gson = new Gson();
        List<Result> expectedResults =  gson.fromJson(expectedResponse, listType);
        System.out.println(expectedResults.size());
        for (Result r : expectedResults){
        	System.out.println(r.id + ":" + r.title);
        }
	}

}
