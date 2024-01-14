class Fridge {
    private var products: MutableList<Product> = mutableListOf<Product>()

    fun addProduct(p: Product) {
        products.add(p)
    }

    fun getProduct(name: String): Product? {
        var p = products.filter{it.name == name}[0]
        return p
    }

    fun getProducts(): List<Product> {
        return products
    }

    fun deleteProduct(name: String) {
        products = products.filter{it.name != name}.toMutableList()
    }

    fun getSweets(): List<Product> {
        var res: MutableList<Product> = mutableListOf<Product>()
        for (p in this.products.filter{it.isSweet}) {
            res.add(p)
        }
        return res
    }

    fun printProducts() {
        println("В холодильнике:")
        for (p in this.getProducts()) {
            println(p.name + ", в количестве " + p.amount + (if (p.isSweet) ", это сладкое, срок годности: " else ", это не сладкое, срок годности: ") + p.humanReadableBestBefore())
        }
    }
}

class Product(val name: String, val isSweet: Boolean, var amount: String?, val bestBefore: String?) {

    override fun toString(): String {
        return this.name + " " + this.amount + " " + this.bestBefore
    }

    fun humanReadableBestBefore(): String { //из DD.MM.YYYY в DD Month YYYY
        if (bestBefore == null) {
            return "У этого продукта не задан срок годности"
        }
        var res: String = ""
        res += this.bestBefore!![0]
        res += this.bestBefore!![1]
        res += " "
        var month: String = this.bestBefore!![3].toString() + this.bestBefore!![4]
        if (month == "01") {res += "января"}
        else if (month == "02") {res += "февраля"}
        else if (month == "03") {res += "марта"}
        else if (month == "04") {res += "апреля"}
        else if (month == "05") {res += "мая"}
        else if (month == "06") {res += "июня"}
        else if (month == "07") {res += "июля"}
        else if (month == "08") {res += "августа"}
        else if (month == "09") {res += "сентября"}
        else if (month == "10") {res += "октября"}
        else if (month == "11") {res += "ноября"}
        else if (month == "12") {res += "декабря"}
        res += " "
        res += this.bestBefore!![6]
        res += this.bestBefore!![7]
        res += this.bestBefore!![8]
        res += this.bestBefore!![9]
        res += " г."
        return res
    }
}

fun main() {
    var fr = Fridge()
    var choco = Product("Шоколад", true, "2 плитки", "28.02.2025")
    var dumplings = Product("Пельмени", false, "700 гр", "30.05.2024")
    fr.addProduct(choco)
    fr.addProduct(dumplings)
    println(fr.getProduct("Шоколад"))
    println(fr.getProducts())
    fr.printProducts()
    println(fr.getSweets())
    fr.deleteProduct("Шоколад")
    fr.printProducts()
}