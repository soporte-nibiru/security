package core.category.domain.output;

public class CategoryOut {

	 private String name;
		
		private String url;
		
		private Long view;
		
		private String image;
		
		private String status;

		public CategoryOut() {
			// TODO Auto-generated constructor stub
		}

		public CategoryOut(String name, String url, Long view, String image, String status) {
			super();
			this.name = name;
			this.url = url;
			this.view = view;
			this.image = image;
			this.status = status;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public Long getView() {
			return view;
		}

		public void setView(Long view) {
			this.view = view;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		
}
