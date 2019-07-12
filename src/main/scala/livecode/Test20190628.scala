package livecode

// live code interview
// interview pair test in london
// categories, with products inside
//1.create category which should have an empty indicator
//2.allow the category to have products which have an id and a publishedYear
//3.add a product to the category

class Category(products: List[Products]) {

  def isEmpty: Boolean = products.isEmpty

  def addProduct(produ: Products): Category = {
    new Category(produ :: products)
  }

  def getProducts: List[Products] = products

}

case class Products(id: String, publishedYear: Int){

}