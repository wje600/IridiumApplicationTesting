package au.com.agic.apptesting.utils;

import javax.validation.constraints.NotNull;

/**
 * A service for determining if something is to be enabled or disabled based on
 * a list of options
 */
public interface EnableDisableListUtils {

	/**
	 *
	 * @param list The list of options (e.g. option1,-option2,+option3)
	 * @param option The option we are inspecting
	 * @return true if the option is enabled
	 */
	boolean enabled(@NotNull final String list, @NotNull final String option);

	/**
	 *
	 * @param list The list of options (e.g. option1,-option2,+option3)
	 * @param option The option we are inspecting
	 * @param  defaultValue the default value if no option is specified
	 * @return true if the option is enabled
	 */
	boolean enabled(@NotNull final String list, @NotNull final String option, final boolean defaultValue);
}
