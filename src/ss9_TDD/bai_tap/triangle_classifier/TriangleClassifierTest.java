package ss9_TDD.bai_tap.triangle_classifier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TriangleClassifierTest {
    @Test
    public void TestEquilateralTraingle() {
        assertEquals("tam giác đều", TriangleClassifier.resultTraingle(2, 2, 2));
    }

    @Test
    public void testTamGiacCan() {
        assertEquals("tam giác cân", TriangleClassifier.resultTraingle(2, 2, 3));
    }

    @Test
    public void testTamGiacThuong() {
        assertEquals("tam giác thường", TriangleClassifier.resultTraingle(3, 4, 5));
    }

    @Test
    public void testKhongPhaiTamGiac1() {
        assertEquals("không phải là tam giác", TriangleClassifier.resultTraingle(8, 2, 3));
    }

    @Test
    public void testKhongPhaiTamGiac2() {
        assertEquals("không phải là tam giác", TriangleClassifier.resultTraingle(-1, 2, 1));
    }

    @Test
    public void testKhongPhaiTamGiac3() {
        assertEquals("không phải là tam giác", TriangleClassifier.resultTraingle(0, 1, 1));
    }
}

