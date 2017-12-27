package test.library.model;

public class SearchCriteria {

	String authorId;
	String book;

	public String getUsername() {
		return authorId;
	}

	public void setUsername(String authorId) {
		this.authorId = authorId;
	}

	public String getEmail() {
		return book;
	}

	public void setEmail(String book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "SearchCriteria [authorId=" + authorId + ", book=" + book + "]";
	}

}
