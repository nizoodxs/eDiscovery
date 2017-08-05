package ediscovery;

/**
 * A console application that tests the UnzipUtility class
 *
 * @author www.codejava.net
 *
 */
public class UnzipUtilityTest {

	public static void main(String[] args) {
		String zipFilePath = "c:/rep.zip";
		String destDirectory = "c:/unzip_file";
		UnzipUtility unzipper = new UnzipUtility();

		try {
			unzipper.unzip(zipFilePath, destDirectory);
		} catch (Exception ex) {
			// some errors occurred
			ex.printStackTrace();
		}
	}

}
