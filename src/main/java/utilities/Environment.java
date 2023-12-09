package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:environmentConfig/${env}.properties" })
public interface Environment extends Config {

	@Key("App.Url")
	String appUrl();

	@Key("App.User")
	String appUserName();

	@Key("App.Pass")
	String appPassword();

	@Key("DB.Host")
	String dbHostName();

	@Key("DB.User")
	String dbUserName();

	@Key("DB.Pass")
	String dbPassword();
}
