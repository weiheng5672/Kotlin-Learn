fun main() {

    // 定義一個 lambda 表達式，將給定的整數 'x' 加上 5
    val addFive = { x: Int -> x + 5 }

    // 使用參數 6 調用 lambda 並將結果存儲到 result1
    val result1 = addFive(6)

    // 打印一個無名的 lambda 表達式（會顯示類型資訊）
    println({ x: Int -> x + 5 })

    // 打印 lambda 函數的引用（會顯示類型資訊）
    println(addFive)

    // 打印 lambda 調用的結果（6 + 5 = 11）
    println(result1)

    // 定義一個 lambda 表達式，將兩個整數 'x' 和 'y' 相加
    val addInt = { x: Int, y: Int -> x + y }

    // 使用參數 15 和 25 調用 lambda 並將結果存儲到 result2
    val result2 = addInt(15, 25)

    // 打印 lambda 函數的引用（會顯示類型資訊）
    println(addInt)

    // 打印 lambda 調用的結果（15 + 25 = 40）
    println(result2)

    // 定義一個返回 "你好" 字符串的 lambda 表達式
    val greeting = { "你好" }

    // 打印 lambda 函數的引用（會顯示類型資訊）
    println(greeting)

    // 打印一個無名的 lambda 表達式（會顯示類型資訊）
    println({ "你好" })

    // 調用 lambda 並打印結果（"你好"）
    println(greeting())

    // 調用無名 lambda 並打印結果（"你好"）
    println( { "你好" }() )

    // IDE會表示這是個多餘的寫法
    // 但它符合程式的規則
    // 此處只是為了演示
    // 既然 {"你好"} 是一個無參數且返回 String 的函數
    // 那麼 {"你好"}() 這樣就是在調用該函數
    // println 就會打印出該函數的返回值，也就是 "你好" 這個字串

    // 如果沒有小括弧，打印時會顯示它的函數類型

    val addSix: (Int) -> Int = { it + 6 }
    println(addSix)
    println(addSix(10))

    // it 是 Kotlin 的一個簡寫用法
    // 當 lambda 表達式只有一個參數時
    // 可以省略參數名稱並使用 it 來引用該參數

    // 在這個例子中，it 代表傳入的整數參數 Int
    // { it + 6 } 的意思是將傳入的參數加上 6 並返回結果

// 當使用 it 作為 lambda 表達式的參數時
// 編譯器需要確定這個 lambda 只有一個參數，而且該參數的類型是已知的
// it 只有在 lambda 的參數類型可以自動推斷的情況下才可以使用
// val addSix = { it + 6 }  這段程式碼無法編譯
// 編譯器無法推斷 it 的類型
// 因為沒有明確的上下文來告訴編譯器這個 lambda 表達式應該接受什麼類型的參數

    val myLambda = { println("你好") }
    //定義了一個名為 myLambda 的 lambda 表達式
    //這個 lambda 沒有參數，執行時會調用 println("你好")，輸出「你好」這個字符串
    //這個 lambda 沒有返回值，所以它的返回類型是 Unit

    println(myLambda)
    //打印 myLambda 變量本身，而不是執行它

    myLambda()
    //調用 myLambda lambda，執行其中的 println("你好")

    println( myLambda() )
    //調用 myLambda，執行 println("你好")，這會先在控制台打印「你好」
    //因為 myLambda() 的返回值是 Unit
    //所以 println(myLambda()) 會打印 kotlin.Unit

    println( println("你好") )
    // 裡面的 println 會先打印出「你好」
    // 因為 println 沒有返回值 所以它的返回類型是 Unit
    // 所以外面的 println 會打印 kotlin.Unit



    // 定義 convert 函數 有兩個輸入 第一個是小數 第二個是Lambda
    // 這種把Lambda作為輸入的函數 就叫做高階函數
    fun convert(
        x: Double,
        converter: (Double) -> Double
        // 第二個參數是 Lambda 表達式，接受一個 Double 並返回一個 Double
    ): Double {

        val result = converter(x)
        // 使用傳入的 Lambda 轉換 x，並將結果存儲到 result

        println("$x is converted to $result")
        // 打印轉換前後的數值

        return result
        // 返回轉換結果
    }

    convert(20.0) { it * 1.8 + 32 }
    // 調用 convert 函數，傳入 20.0 和一個用來將攝氏溫度轉換為華氏溫度的 Lambda


    // 當然 這是個簡單的例子 也許不怎麼高級
    // 但這種特性 可以實現非常複雜的功能 所以叫做高階函數
    // 通常我們不會自己去寫高階函式
    // 但會很常去使用它

// 高階函數可以讓你 靈活地 將 行為(Lambda) 作為 參數 傳遞
// 雖然這裡的例子很簡單，但這種特性在處理複雜邏輯時非常強大，比如在處理集合、異步編程或自定義操作時
// 理解和使用高階函數是掌握 Kotlin 的關鍵之一，也是現代編程的核心技術之一

}


/*
    Function0<java.lang.String>
    表示一個無參數且返回 String（即 java.lang.String）的函數

    Function1<T, R>
    表示一個具有一個參數且返回 R 類型的函數，其中 T 是參數類型，R 是返回類型

    Function2<T1, T2, R>
    表示一個具有兩個參數且返回 R 類型的函數，依此類推

    {"你好"} 這個 lambda
    是一個無參數且返回 String 的函數
    所以它的類型是 Function0<String>

*/