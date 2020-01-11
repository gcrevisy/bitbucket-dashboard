package fr.alteca.dashboard.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.PullRequest;
import fr.alteca.dashboard.model.PullRequestModel;
import fr.alteca.dashboard.model.Repository;
import fr.alteca.dashboard.model.RepositoryModel;

@Service
public class DashboardService {
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private BrancheService brancheService;

    @Autowired
    private PullRequestService pullRequestService;

    public List<RepositoryModel> listerPullRequests(Contexte contexte) throws DashboardException {
        List<RepositoryModel> result = new ArrayList<RepositoryModel>();

        List<Repository> repositories = repositoryService.listerRepositories(contexte);
        for (Repository repository : repositories) {
            RepositoryModel model = new RepositoryModel();
            model.name(repository.getName());
            contexte.setProjectName(repository.getName());
            List<PullRequest> requests = pullRequestService.listerPullRequest(contexte);

            for (PullRequest request : requests) {
                String dateCreation = new String("");
                if (request.getDateCreation() != null) {
                    dateCreation = new SimpleDateFormat("dd/MM/yyyy").format(request.getDateCreation().getTime());
                }
                model.getPullRequests().add(new PullRequestModel(request.getId(), request.getName(), dateCreation,
                        request.getAuteur(), request.getBrancheDepart(), request.getBrancheArrivee()));
            }

            result.add(model);
        }
        return result;
    }

    public List<RepositoryModel> listerBranches(Contexte contexte) {
        List<RepositoryModel> result = new ArrayList<RepositoryModel>();
        return result;
    }

}