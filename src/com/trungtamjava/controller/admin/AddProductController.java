package com.trungtamjava.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.impl.CategoryDaoImpl;
import com.trungtamjava.dao.impl.ProductDaoImpl;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;

@WebServlet(urlPatterns = "/admin/product/add")
public class AddProductController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryDao categoryDao = new CategoryDaoImpl();
		List<Category> categoryList = categoryDao.search("");
		req.setAttribute("categoryList", categoryList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/product/addProduct.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//tao doi tuong de luu tam thoi file upload len vao
			DiskFileItemFactory factory = new DiskFileItemFactory();

			/// doi thanh duong dan toi thu muc, luu tam thoi file upload len
			factory.setRepository(new File("/Volumes/Data/files"));
			///TREN WINDOW THI D:\\files (thu muc files trong o D)

			//nho truyen factory vao consrtuctor
			// doc request tu client gui len trong form upload
			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
			/// danh sach cac truong input tu form client
			// duoc goi la fileitem
			List<FileItem> fieldList = servletFileUpload.parseRequest(req);

			Product product = new Product();
			// lay ra tung input
			for (FileItem item : fieldList) {
				System.out.println("1");
				if (item.getFieldName().equals("name")) {
					String name = item.getString();
					product.setName(name);
				}
				System.out.println("2");
				if (item.getFieldName().equals("price")) {
					String price = item.getString();
					product.setPrice(Integer.parseInt(price));
				}
				System.out.println("3");
				if (item.getFieldName().equals("description")) {
					String description = item.getString();
					product.setDescription(description);
				}
				System.out.println("4");
				if (item.getFieldName().equals("categoryId")) {
					String categoryId = item.getString();

					Category category = new Category();
					category.setId(Integer.parseInt(categoryId));
					product.setCategory(category);
				}
				System.out.println("5");
				if (item.getFieldName().equals("imageFile")) {
					//kiem tra dung luong file upload
					if (item.getSize() > 0) {//neu co upload file
						final String UPLOAD_FOLDER = "/Volumes/Data/files";
						//tao 1 file tren server
						//tim dinh dang file
						String name = item.getName();//tra ve ten file upload
						int index = name.lastIndexOf(".");
						String ext = name.substring(index);//lay ra phan dinh dang file
						
						//MINH se ko lay ten file anh upload len, vi se xay ra trung ten
						// ma tao 1 file ten moi
						///tao file de luu tren server
						String image = System.currentTimeMillis() + ext;//ten file anh moi
						File file = new File(UPLOAD_FOLDER + File.separator + image);
						
						//ghi du lieu upload len vao file
						item.write(file);
						
						product.setImage(image);//luu lai ten file anh vao product
					}
				}
			}

			System.out.println("6");
			ProductDao producDao = new ProductDaoImpl();
			producDao.add(product);

			resp.sendRedirect(req.getContextPath() + "/admin/product/search");
		} catch (Exception e) {
			System.out.println("Loi " + e);
		}

	}

}
