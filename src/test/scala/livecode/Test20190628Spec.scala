package livecode

import org.scalatest.{FunSuite, Matchers}

class Test20190628Spec extends FunSuite with Matchers {

  test("create an empty category") {

    val category1 = new Category(List.empty[Products])
    category1.isEmpty shouldBe true
  }

  test("add a product to a category") {

    val category1 = new Category(List.empty[Products])
    val category2 = category1.addProduct(new Products("Prod1", 2003))
    category2.isEmpty shouldBe(false)

    val a = category2.getProducts(0)
    a.id shouldBe "Prod1"
    a.publishedYear shouldBe 2003
  }
}