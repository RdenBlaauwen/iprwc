package nl.rdenblaauwen;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.bundles.assets.AssetsBundleConfiguration;
import io.dropwizard.bundles.assets.AssetsConfiguration;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Peter van Vliet
 */
public class ApiConfiguration extends Configuration implements AssetsBundleConfiguration
{
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @NotEmpty
    @JsonProperty
    private String apiName;

    @Valid
    @NotNull
    @JsonProperty
    private final AssetsConfiguration assets = new AssetsConfiguration();

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }
    @JsonProperty
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    @JsonProperty
    public String getTemplate() {
        return template;
    }
    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }
    
    public String getApiName()
    {
        return apiName;
    }

    public void setApiName(String apiName)
    {
        this.apiName = apiName;
    }

    @Override
    public AssetsConfiguration getAssetsConfiguration()
    {
        return assets;
    }

    @Valid
    @NotNull
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }

    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }
}
