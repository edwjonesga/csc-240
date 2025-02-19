import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MainTest {
    
    @Test
    public void testClimbingStairs() {
        assertEquals(2, ClimbingStairs.countWays(2));
        assertEquals(3, ClimbingStairs.countWays(3));
        assertEquals(5, ClimbingStairs.countWays(4));
    }
    
    @Test
    public void testGridPaths() {
        assertEquals(6, GridPaths.countPaths(3, 3));
        assertEquals(1, GridPaths.countPaths(1, 5));
        assertEquals(1, GridPaths.countPaths(5, 1));
    }
    
    @Test
    public void testGridPathsWithObstacles() {
        int[][] grid1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        assertEquals(2, GridPathsWithObstacles.countPaths(grid1));
        
        int[][] grid2 = {{0, 0}, {1, 0}};
        assertEquals(1, GridPathsWithObstacles.countPaths(grid2));
    }
    
    @Test
    public void testDiceRollSum() {
        assertEquals(1, DiceRollSum.countWays(1, 6));
        assertEquals(6, DiceRollSum.countWays(6, 6));
        assertEquals(21, DiceRollSum.countWays(7, 6));
    }
    
    @Test
    public void testTiling2xN() {
        assertEquals(1, Tiling2xN.countWays(1));
        assertEquals(2, Tiling2xN.countWays(2));
        assertEquals(3, Tiling2xN.countWays(3));
        assertEquals(5, Tiling2xN.countWays(4));
    }
}
