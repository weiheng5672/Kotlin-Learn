/*

Kotlin 擁有大量內建的高階函數

filter 家族 : 將集合精簡到合適的大小
map : 轉換集合
forEach : 遍歷集合中的項目
groupBy : 將集合中的項目進行分組
fold : 在一行代碼中執行複雜的計算

*/

// 為了展示高階函數在處理複雜資料中的應用，定義了一個較為複雜的範例
// 這個例子經過精心設計，既足夠複雜以展示高階函數的能力，又足夠簡單，讓人可以逐行理解
// 在實際應用中，處理大量資料時，通常無法逐行檢視這些資料，因此在學習過程中，這樣的簡化範例更易於理解
// 我自己在最初也對這部分理解不深，但在實際使用 `map` 等高階函數處理資料時，才真正感受到它們的強大
// 現在才回過頭來想仔細考察這些功能，實務中的資料通常非常龐大，這樣的示例幫助我們掌握其核心概念

// 這是一個雜物的類
// 它具有 名字 種類 單位 單價 數量 這些屬性
data class Grocery(
    val name: String,
    val category: String,
    val unit: String,
    val unitPrice: Double,
    val quantity: Int
)

fun main() {

    //這是一個雜物的List
    //所謂的內建高階函式 就是List內建的
    //用來處理List本身的功能
    val groceries = listOf(
        Grocery("番茄", "蔬菜", "磅", 3.0, 3),
        Grocery("蘑菇", "蔬菜", "磅", 4.0, 1),
        Grocery("貝果", "烘焙", "包", 1.5, 2),
        Grocery("橄欖油", "儲藏", "瓶", 6.0, 1),
        Grocery("冰淇淋", "冷凍", "包", 3.0, 2)
    )

    // 使用鏈式調用 List 的 maxByOrNull 高階函式
    // maxByOrNull 會根據提供的 lambda 表達式計算出最大的值
    // 這裡我們找到單價最高的雜物
    val highestUnitPrice = groceries.maxByOrNull { it.unitPrice }
    println("單價最高: $highestUnitPrice")

    // 使用 minByOrNull 高階函式
    // minByOrNull 會根據提供的 lambda 表達式計算出最小的值
    // 這裡我們找到數量最少的雜物
    val lowestQuantity = groceries.minByOrNull { it.quantity }
    println("數量最少: $lowestQuantity")

    // 使用 sumOf 高階函式
    // sumOf 會計算 List 中所有元素在指定屬性上的總和
    // 這裡我們計算所有雜物的總數量
    val sumQuantity = groceries.sumOf { it.quantity }
    println("雜物的總數量: $sumQuantity")

    // 使用 sumOf 高階函式來計算總價格
    // 這裡我們計算每個物品的單價乘以數量，再將所有價格加總
    val totalPrice = groceries.sumOf { it.unitPrice * it.quantity }
    println("總價: $totalPrice")


    // 這邊演示了一個不使用 it 的寫法
    // 仔細研究 高階函數的lambda參數
    val totalPrice2 = groceries.sumOf { item: Grocery ->  item.unitPrice * item.quantity }
    println("總價: $totalPrice2")

    // groceries 是一個List
    // List的每一個項目都是Grocery類型的物件
    // 而 lambda作為一個函數
    // 它的輸入就是 Grocery類型的參照
    // 輸出就是 Grocery類型的其中一個屬性
    // 而這裡進一步選出兩個屬性 將他們相乘
    // 然後針對 List的每一個項目 去加總

    println()
    println("=====================認識Filter函式==========================")
    println()

    // 使用 filter 高階函式來過濾出類別為 "蔬菜" 的雜物
    val vegetables = groceries.filter { it.category == "蔬菜" }
    println("蔬菜: $vegetables")

    // 使用 filterNot 高階函式來過濾出類別不為 "冷凍" 的雜物
    val notFrozen = groceries.filterNot { it.category == "冷凍" }
    println("非冷凍: $notFrozen")


    println()
    println("=====================用map對集合執行轉換==========================")
    println()

    // 使用 map 高階函式 提取所有雜物的名稱
    val groceryNames = groceries.map { it.name }
    println("所有雜物的名稱: $groceryNames")

    // 使用 map 高階函式 提取所有雜物的單價
    val groceryUnitPrice = groceries.map { it.unitPrice }
    println("所有雜物的單價: $groceryUnitPrice")

    println()
    println("=====================高階函式可以鏈式調用==========================")
    println()

    // 使用 filter 和 map 高階函式鏈式調用
    // 首先過濾出單價大於 3.0 的雜物，然後提取這些雜物的名稱
    val groceryGreaterThan3 =
        groceries.filter { it.unitPrice > 3.0 }.map { it.name }
    println("單價大於 3.0 的雜物: $groceryGreaterThan3")


    println()
    println("=====================高階函式forEach==========================")
    println()

    // 使用 forEach 高階函式來打印每個雜物的名稱
    println("所有雜物的名稱: ")
    groceries.forEach { println(it.name) }

    // 使用 filter 和 forEach 高階函式鏈式調用
    // 首先過濾出單價大於 3.0 的雜物，然後打印這些雜物的名稱
    println("單價大於 3.0 的雜物: ")
    groceries.filter { it.unitPrice > 3.0 }.forEach { println(it.name) }

    // 使用 forEach 高階函式來遍歷每個雜物並將其名稱串接起來
    var itemNames = ""
    groceries.forEach { itemNames += it.name }
    println("itemNames: $itemNames")

    /*
    在 Kotlin 中
    closure 是指一個 lambda 表達式
    可以捕獲其外部作用域中的變數
    並且可以訪問和修改這些變數
    即使該變數已經超出了其原始作用域

    當 lambda 表達式 { itemNames += it.name } 被執行時
    它會訪問外部變數 itemNames
    並將每個 Grocery 物件的名稱連接到 itemNames 變數中
    這意味著即使 itemNames 的原始作用域是 main 函數
    lambda 表達式仍然能夠讀取和修改 itemNames

    這種行為是 closure 的一部分
    展示了 lambda 表達式如何與其外部作用域進行互動
    這在許多情況下是非常有用的
    比如在進行資料處理和事件處理時
    */

}
