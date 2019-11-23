import java.lang.ref.WeakReference
import kotlin.reflect.KProperty


class Weak<T>(value: T)
{
    var weakRef: WeakReference<T> = WeakReference(value)
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        return weakRef.get()
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, newVal: T) {
        weakRef = WeakReference(newVal)
    }
}


class Employee(name: String, age: Int, salary: Double)
{
    var name: String? by Weak(name)
    var age: Int? by Weak(age)
    var salary: Double? by Weak(salary)

}


fun main()
{
    val employee = Employee("Brian",45,135000.0)

    println("${employee.name}\t${employee.age}\t${employee.salary}")

    employee.age = 46
    employee.salary = 158000.0

    println("${employee.name}\t${employee.age}\t${employee.salary}")

}