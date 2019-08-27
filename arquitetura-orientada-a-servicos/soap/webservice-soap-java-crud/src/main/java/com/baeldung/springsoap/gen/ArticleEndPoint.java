package com.baeldung.springsoap.gen;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.unifacs.demo.AddArticleRequest;
import br.unifacs.demo.AddArticleResponse;
import br.unifacs.demo.ArticleInfo;
import br.unifacs.demo.DeleteArticleRequest;
import br.unifacs.demo.DeleteArticleResponse;
import br.unifacs.demo.GetAllArticlesResponse;
import br.unifacs.demo.GetArticleByIdRequest;
import br.unifacs.demo.GetArticleByIdResponse;
import br.unifacs.demo.ServiceStatus;
import br.unifacs.demo.UpdateArticleRequest;
import br.unifacs.demo.UpdateArticleResponse;

@Endpoint
public class ArticleEndPoint {

	private static final String NAMESPACE_URI = "http://www.concretepage.com/article-ws";
	
	@Autowired
	private ArticleService articleService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getArticleByIdRequest")
	@ResponsePayload
	public GetArticleByIdResponse getArticle(@RequestPayload GetArticleByIdRequest request) {
		GetArticleByIdResponse response = new GetArticleByIdResponse();
		ArticleInfo articleInfo = new ArticleInfo();
		BeanUtils.copyProperties(articleService.getArticleById(request.getArticleId()), articleInfo);
		response.setArticleInfo(articleInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllArticlesRequest")
	@ResponsePayload
	public GetAllArticlesResponse getAllArticles() {
		GetAllArticlesResponse response = new GetAllArticlesResponse();
		List<ArticleInfo> articleInfoList = new ArrayList<>();
		List<Article> articleList = articleService.getAllArticles();
		for (int i = 0; i < articleList.size(); i++) {
			ArticleInfo ob = new ArticleInfo();
			BeanUtils.copyProperties(articleList.get(i), ob);
			articleInfoList.add(ob);
		}
		response.getArticleInfo().addAll(articleInfoList);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addArticleRequest")
	@ResponsePayload
	public AddArticleResponse addArticle(@RequestPayload AddArticleRequest request) {
		AddArticleResponse response = new AddArticleResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		Article article = new Article();
		article.setTitle(request.getTitle());
		article.setCategory(request.getCategory());
		boolean flag = articleService.addArticle(article);
		if (flag == false) {
			serviceStatus.setStatusCode("CONFLICT");
			serviceStatus.setMessage("Content Already Available");
			response.setServiceStatus(serviceStatus);
		} else {
			ArticleInfo articleInfo = new ArticleInfo();
			BeanUtils.copyProperties(article, articleInfo);
			response.setArticleInfo(articleInfo);
			serviceStatus.setStatusCode("SUCCESS");
			serviceStatus.setMessage("Content Added Successfully");
			response.setServiceStatus(serviceStatus);
		}
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateArticleRequest")
	@ResponsePayload
	public UpdateArticleResponse updateArticle(@RequestPayload UpdateArticleRequest request) {
		Article article = new Article();
		BeanUtils.copyProperties(request.getArticleInfo(), article);
		articleService.updateArticle(article);
		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Content Updated Successfully");
		UpdateArticleResponse response = new UpdateArticleResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteArticleRequest")
	@ResponsePayload
	public DeleteArticleResponse deleteArticle(@RequestPayload DeleteArticleRequest request) {
		Article article = articleService.getArticleById(request.getArticleId());
		ServiceStatus serviceStatus = new ServiceStatus();
		if (article == null) {
			serviceStatus.setStatusCode("FAIL");
			serviceStatus.setMessage("Content Not Available");
		} else {
			articleService.deleteArticle(article);
			serviceStatus.setStatusCode("SUCCESS");
			serviceStatus.setMessage("Content Deleted Successfully");
		}
		DeleteArticleResponse response = new DeleteArticleResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

}