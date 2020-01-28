package fr.alteca.dashboard.utils;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;

public final class UriBuilder {

  private static Logger logger = LoggerFactory.getLogger(UriBuilder.class);

  public static URI buildUri(Contexte contexte) throws DashboardException {
	ModelValidator.validerContexte(contexte);
	URI uri = null;
	// "https://bitbucket.b.bbg/rest/api/1.0/projects/parme/repos/parme-service-protection/pull-requests"
	String uriValue = "https://bitbucket.b.bbg/rest/api/1.0/projects/";

	if (StringUtils.isNotBlank(contexte.getRepositoryName())) {
	  uriValue += contexte.getRepositoryName() + "/repos";
	  if (StringUtils.isNotBlank(contexte.getProjectName())) {
		uriValue += "/" + contexte.getProjectName();
		if (contexte.isGettingBrancheInfo()) {
		  uriValue += "/refs/branches/";
		  if (StringUtils.isNotBlank(contexte.getBrancheName())) {
			uriValue += contexte.getBrancheName();
		  }
		} else if (contexte.isGettingPullRequestInfo()) {
		  uriValue += "/pull-requests/";
		}
	  }
	}
	uriValue += "?limit=" + contexte.getPageSize();
	try {
	  logger.info("Construction de l'uri " + uriValue);
	  uri = new URI(uriValue);
	} catch (URISyntaxException e) {
	  logger.error("Impossible de construire l'URI avec le contexte" + contexte.toString());
	  throw new DashboardException("Impossible de construire l'URI avec le contexte" + contexte.toString(), e);
	}

	return uri;
  }

  private UriBuilder() {
  }

}