import kotlin.test.Test
import kotlin.test.assertEquals
import org.exotechasset.exotechasset.entity.AssetStatus

internal class AssetStatusTest {
    private val status: AssetStatus = AssetStatus.PENDING

    @Test
    fun testToString() {
        assertEquals("Deployable", AssetStatus.DEPLOYABLE.toString())
        assertEquals("Pending", AssetStatus.PENDING.toString())
        assertEquals("Deployed", AssetStatus.DEPLOYED.toString())
        assertEquals("Undeployable", AssetStatus.UNDEPLOYABLE.toString())
    }

    // @Test
    // fun testOf() {
    //     assertEquals(AssetStatus.DEPLOYABLE, AssetStatus.of("Deployable"))
    //     assertEquals(AssetStatus.PENDING, AssetStatus.of("Pending"))
    //     assertEquals(AssetStatus.DEPLOYED, AssetStatus.of("Deployed"))
    //     assertEquals(AssetStatus.UNDEPLOYABLE, AssetStatus.of("Undeployable"))
    // }

    // @Test(expected = IllegalArgumentException::class)
    // fun testOf() {
    //     AssetStatus.of("Invalid status string")
    // }
}
