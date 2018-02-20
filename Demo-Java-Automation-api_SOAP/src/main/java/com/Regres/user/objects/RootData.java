package com.Regres.user.objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.Regres.user.objects.RootData;



import java.util.List;

public class RootData {
	
	private Long page;
	@JsonProperty("per_page")
	private Long perPage;
	private Long total;
	@JsonProperty("total_pages")
	private Long totalPages;
	private List<GetUserResponse> data = null;

	public Long getPage() {
	return page;
	}

	public void setPage(Long page) {
	this.page = page;
	}

	public Long getPerPage() {
	return perPage;
	}

	public void setPerPage(Long perPage) {
	this.perPage = perPage;
	}

	public Long getTotal() {
	return total;
	}

	public void setTotal(Long total) {
	this.total = total;
	}

	public Long getTotalPages() {
	return totalPages;
	}

	public void setTotalPages(Long totalPages) {
	this.totalPages = totalPages;
	}

	public List<GetUserResponse> getData() {
	return data;
	}

	public void setData(List<GetUserResponse> data) {
	this.data = data;
	}

	
}
