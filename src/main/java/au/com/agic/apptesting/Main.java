package au.com.agic.apptesting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	private Main() {
	}

	public static void main(final String... args) {
		final List<File> globalTempFiles = new ArrayList<>();

		try {
			/*
				This is required to run ZAP from webstart
			 */
			System.setSecurityManager(null);

			/*
				Execute the tests
			 */
			final int failures = new TestRunner().run(globalTempFiles);

			/*
				Write some output to let the caller know how many failures there were
			 */
			LOGGER.info("WEBAPPTESTER-INFO-0008: TestRunner experienced {} failures", failures);

			System.exit(failures);
		} catch (final Exception ex) {
			LOGGER.error(
				"WEBAPPTESTER-BUG-0007: "
				+ "An exception was raised while attempting to run the Cucumber test scripts", ex);
			System.exit(-1);
		} finally {
			try {
				globalTempFiles.forEach(File::delete);
			} catch (final Exception ex) {
				LOGGER.error(
					"WEBAPPTESTER-BUG-0008: Failed to remove global temp file", ex);
			}
		}
	}
}
