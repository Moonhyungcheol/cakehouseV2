import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils {

	public <T> void save(String filename, List<T> list) {

		try (FileOutputStream fos = new FileOutputStream(filename);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream out = new ObjectOutputStream(bos)) {

			out.writeObject(list);

		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	public <T> List<T> load(String filename) {

		List<T> list = null;

		try (FileInputStream fis = new FileInputStream(filename);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream in = new ObjectInputStream(bis)) {
			
			list = (ArrayList<T>) in.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
