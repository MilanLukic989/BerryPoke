import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class BerryUtil {

	private static String rootURL = "https://pokeapi.co/api/v2/berry";
	private ArrayList<Berry> berries;

	public BerryUtil() {
		berries = new ArrayList<Berry>();
	}

	public ArrayList<Berry> getBerries() {
		return berries;
	}

	public Berry getBerryById(int id) {
		return berries.stream().filter(b -> (id == b.getId())).findFirst().get();
	}

	private static Berry pickFastestGrowing(final Berry berry1, final Berry berry2) {
		return berry1.getGrowthPerHour() > berry2.getGrowthPerHour() ? berry1 : berry2;
	}

	public Berry getFastestGrowing() {
		return berries.stream().reduce(BerryUtil::pickFastestGrowing).get();
	}
	
	public void printAllBerries() {
		for(Berry b : berries) {
			System.out.println(b);
		}
	}

	public void loadAllBerries() throws IOException {
		String urlAddr = rootURL;
		int berryCounter = 0;

		URL request = new URL(urlAddr);
		InputStream openStream = request.openStream();
		String response = IOUtils.toString(openStream);

		JSONObject root = new JSONObject(response);

		int count = root.getInt("count");
		String nextUrlAddr;
		JSONArray berriesResult;
		Berry berryTmp;

		while (berryCounter < count) {
			nextUrlAddr = root.optString("next");
			berriesResult = (JSONArray) root.get("results");

			for (int i = 0; i < berriesResult.length(); i++) {
				JSONObject jsonObj = (JSONObject) berriesResult.get(i);
				String name = jsonObj.getString("name");
				String berryUrl = jsonObj.getString("url");

				request = new URL(berryUrl);
				openStream = request.openStream();
				response = IOUtils.toString(openStream);
				root = new JSONObject(response);
				int growthTime = root.getInt("growth_time");
				int size = root.getInt("size");

				berryTmp = new Berry(root.getInt("id"), name, berryUrl, growthTime, size);
				berryTmp.setGrowthPerHour((double) size / growthTime);
				berries.add(berryTmp);
				berryCounter++;
			}

			if (!nextUrlAddr.isEmpty()) {
				request = new URL(nextUrlAddr);
				openStream = request.openStream();
				response = IOUtils.toString(openStream);
				root = new JSONObject(response);
			}
		}
	}
}
