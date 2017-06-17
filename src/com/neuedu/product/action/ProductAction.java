package com.neuedu.product.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neuedu.product.entity.Product;
import com.neuedu.product.mapper.ProductMapper;

public class ProductAction {

	private static final long serialVersionUID = -5965885617410849125L;

	@Autowired
	private ProductMapper productMapper;

	private Product product;
	private List<Product> listpro;

	public String findallpro() throws IOException {

		// 设置http相关协议 接收相关数据 并返回Json格式的数据
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String action = request.getParameter("action");
		String id =request.getParameter("proId");
		String type=request.getParameter("type");
		String aa=request.getParameter("aa");
		String listid=request.getParameter("listid");
		//String转List
		
		// 检验
		HttpSession se = request.getSession();
		if (action != null) {

			if (action.equals("findallpro")) {
				listpro = productMapper.getAllProduct();
			} else if (action.equals("findonepro") && id != null) {
				Integer proId = Integer.parseInt(id);
				product = productMapper.getOneProduct(proId);
			}else if(action.equals("findtypepro")&&type!=null){
				listpro=productMapper.findtypepro(type);
			}else if(action.equals("findcarpro")&&listid!=null){	
				Gson gson=new Gson();
				List<String> proid=gson.fromJson(listid, ArrayList.class);
				listpro=new ArrayList<Product>();
				for (String proIds : proid) {
					Integer proId=Integer.parseInt(proIds);
					product = productMapper.getOneProduct(proId);
					listpro.add(product);
				}
				product=null;
			}else if(action.equals("search")&&aa!=null){
				listpro=productMapper.findtypepro(aa);
				if(listpro.size()>0&&listpro!=null){
					//break;
				}else{
					listpro=productMapper.search(aa);
				}
			}
			else {
				listpro = null;
			}
		} else {
			listpro = null;
		}
		// 打包数据以json格式送回去
		Gson gson = (new GsonBuilder()).create();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(product!=null){
			out.print(gson.toJson(product));
		}else{
			out.print(gson.toJson(listpro));
		}
		
		out.close();
		System.out.println(gson.toJson(product));
		System.out.println(gson.toJson(listpro));

		return null;
	}

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
