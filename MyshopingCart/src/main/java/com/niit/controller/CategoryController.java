package com.niit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.domain.Category;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;

	// displays all the Categories in the table
	@RequestMapping(value = "/getAllCategories")
	public ModelAndView getAllCategories() {
		List<Category> allcategories = categoryDAO.list();
		ModelAndView mv = new ModelAndView("category", "categoryList", allcategories);

		return mv;
	}

	// add Category
	// method 1 for add Categry
	@RequestMapping("/manage_category_create")
	public ModelAndView getcreateCategoryForm() {
		ModelAndView mv = new ModelAndView("/createCategoryForm");
		mv.addObject("createCategoryObj", category);
		return mv;

	}

	// add Category
	// method 2 for add Categry
	@RequestMapping(value = "/manage_category_create", method = RequestMethod.POST)
	public ModelAndView createCategory(@Valid @ModelAttribute(value = "createCategoryObj") Category category,
			BindingResult result) {

		ModelAndView mv = new ModelAndView("adminHome");
		if (result.hasErrors())
			return new ModelAndView("createCategoryForm");
		if (categoryDAO.save(category)) {
			mv.addObject("message", "Successfully created the category");
			mv.addObject("categoryList", categoryDAO.list());
			mv.addObject("isUserClickedCategories", "true");

		} else {
			mv.addObject("message", "Not able to create Category.Please contact Administrator");

		}
		return mv;

	}

	// @GetMapping("/manage_category_delete/{id}")
	@RequestMapping(value = "/manage_category_delete/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable(value = "id") int id, Model model) {

		Category category = categoryDAO.getCategoryByID(id);
		categoryDAO.delete(category);
		return "redirect:/getAllCategories";

	}

	// edit Category
	// method 1 for edit Categry
	@RequestMapping(value = "/manage_category_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditCategoryForm(@PathVariable(value = "id") int id) {
		Category category = this.categoryDAO.getCategoryByID(id);
		return new ModelAndView("editCategoryForm", "editCategoryObj", category);
	}

	// edit Category
	// method 2 for edit Categry
	@RequestMapping(value = "/manage_category_edit", method = RequestMethod.POST)
	public String editCategory(@ModelAttribute(value = "editCategoryObj") Category category, Model model) {
		this.categoryDAO.update(category);
		return "redirect:/getAllCategories";

	}
}
