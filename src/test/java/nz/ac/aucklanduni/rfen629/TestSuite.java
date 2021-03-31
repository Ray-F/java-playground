package nz.ac.aucklanduni.rfen629;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.lang.reflect.Field;
import java.util.Arrays;

import nz.ac.aucklanduni.rfen629.algorithm.Algorithms;
import nz.ac.aucklanduni.rfen629.algorithm.Paths;
import nz.ac.aucklanduni.rfen629.problems.Anagram;
import nz.ac.aucklanduni.rfen629.problems.MinimumSums;
import nz.ac.aucklanduni.rfen629.problems.Nodes;
import nz.ac.aucklanduni.rfen629.problems.Nodes.ListNode;
import nz.ac.aucklanduni.rfen629.problems.Permutations;
import nz.ac.aucklanduni.rfen629.problems.SingleNumber;
import nz.ac.aucklanduni.rfen629.problems.Stock;
import nz.ac.aucklanduni.rfen629.problems.UniquePaths;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Suite.class)
@SuiteClasses({
        TestSuite.UniquePathsITest.class,
        TestSuite.UniquePathsIITest.class
})

public class TestSuite {

    static MinimumSums minimumSums = new MinimumSums();
    static UniquePaths uniquePaths = new UniquePaths();
    static SingleNumber singleNumber = new SingleNumber();
    static Paths paths = new Paths();
    static Nodes nodes = new Nodes();
    static Anagram anagram = new Anagram();
    static Stock stock = new Stock();
    static Permutations permutations = new Permutations();

    public static class PermutationsTest {

        @Test
        public void testPermutations() {
            Object[] testVals = new Object[] {1, 1, 1, 1};

            //
            /*
             * All combinations with order considered
             * 123 -> 123, 132, 213, 231, 312, 321
             */

            System.out.println(permutations.permuteAsObject(testVals));
            System.out.println(permutations.permuteAsObject(testVals).size());
        }
    }

    public static class StockTest {

        @Test
        public void testStock() {
            assertEquals(7, stock.maxProfitII(new int[]{7,1,5,3,6,4}));
            assertEquals(4, stock.maxProfitII(new int[]{1,2,3,4,5}));
            assertEquals(0, stock.maxProfitII(new int[]{7,6,4,3,1}));
        }
    }

    public static class AnagramTest {

        @Test
        public void testAnagram() {
            assertTrue(anagram.isAnagram("anagram", "naagram"));
            assertFalse(anagram.isAnagram("aacc", "cacc"));
            assertFalse(anagram.isAnagram("aabbcc", "aaccdd"));
        }
    }

    public static class PathsTest {

        @Test
        public void testPaths() {
            int nVertices = 5;
            int[][] grid = new int[nVertices][nVertices];

            for (int i = 0; i < nVertices; i++) {
                for (int j = 0; j < nVertices; j++) {
                    grid[i][j] = (int) Math.round(Math.random());
                }
            }

            // Print the grid
            for (int i = 0; i < nVertices; i++) {
                System.out.println(Arrays.toString(grid[i]));
            }


            boolean hasPath = paths.pathExistence(grid, 4, 1);

            System.out.print(hasPath);
        }

    }

    public static class NodesTest {

        public static class Person {
            // Age shouldn't be accessible outside of the person class, and shouldn't be able to be changed
            private final int age;

            public Person() { this.age = 20; }

            public void printMyAge() {
                System.out.println("My age is " + age);
            }
        }

        @Test
        public void testNull() {
            Person person = new Person();

            // Before setting private field through reflection
            person.printMyAge();

            try {
                Class<?> cls = Class.forName(person.getClass().getName());
                Field newField = cls.getDeclaredField("age");
                newField.setAccessible(true);
                newField.setInt(person, 10);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // After setting private field through reflection
            person.printMyAge();
        }

        public void printNodeVal(ListNode node) {
            if (node.next != null) {
                printNodeVal(node.next);
            }

            System.out.println(node.val);
        }

        @Test
        public void reverseList_Success() {
            ListNode node = new ListNode(1, new ListNode(2, new ListNode( 3, new ListNode(4, new ListNode(5)))));

            printNodeVal(nodes.reverseList(node));
        }
    }

    public static class SingleNumberTest {
        @Test
        public void testFunction() {
            int a = 0b01011010;
            int b = 0b01000101;
            System.out.printf("%d + %d = %d (%s)\n", a, b, a + b, Integer.toString(a + b, 2));


            int sum = Algorithms.sum(a, b);
            System.out.printf("%d (%s)", sum, Integer.toString(sum, 2));
        }

        @Test
        public void singleNumber_5_Success() {
            int[] testCase = {1, 2, 3, 1, 2};
            assertEquals(3, singleNumber.singleNumber(testCase));
        }

        @Test
        public void singleNumber3_6_Success() {
            int[] testCase = {1, 1, 2, 2, 3, 5, 6, 6, 8, 8, 3, 11};

            int[] actual = singleNumber.singleNumber3(testCase);

            try {
                assertArrayEquals(new int[] {11, 5}, actual);
            } catch (AssertionError e) {
                assertArrayEquals(new int[] {5, 11}, actual);
            }
        }
    }

    public static class MinimumSumsTest {
        @Test
        public void minPathSum_2x2_Success() {
            int[][] testCase = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
            assertEquals(7, minimumSums.minPathSum(testCase));
        }
    }

    public static class UniquePathsITest {
        @Test
        public void uniquePaths_1x1_Success() {
            assertEquals(1, uniquePaths.uniquePaths(1, 1));
        }

        @Test
        public void uniquePaths_3x3_Success() {
            assertEquals(6, uniquePaths.uniquePaths(3, 3));
        }

        @Test
        public void uniquePaths_10x10_Success() {
            assertEquals(48620, uniquePaths.uniquePaths(10, 10));
        }

        @Test
        public void uniquePaths_23x12_Success() {
            assertEquals(193536720, uniquePaths.uniquePaths(23, 12));
        }
    }

    public static class UniquePathsIITest {
        @Test
        public void uniquePathsWithObstacles_NoBlock1_Success() {
            /*
             * - - -
             * - - -
             * - - !
             */
            int[][] testCase = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
            assertEquals(6, uniquePaths.uniquePathsWithObstacles(testCase));
        }

        @Test
        public void uniquePathsWithObstacles_NoBlock2_Success() {
            /*
             * - - - -
             * - - - -
             * - - - !
             */
            int[][] testCase = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            assertEquals(10, uniquePaths.uniquePathsWithObstacles(testCase));
        }

        @Test
        public void uniquePathsWithObstacles_NoBlock3_Success() {
            /*
             * - - - -
             * - - - -
             * - - - -
             * - - - -
             * - - - !
             */
            int[][] testCase = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            assertEquals(35, uniquePaths.uniquePathsWithObstacles(testCase));
        }


        @Test
        public void uniquePathsWithObstacles_OneBlock1_Success() {
            /*
             * - B
             * - !
             */
            int[][] testCase = {{0, 1}, {0, 0}};
            assertEquals(1, uniquePaths.uniquePathsWithObstacles(testCase));
        }

        @Test
        public void uniquePathsWithObstacles_OneBlock2_Success() {
            /*
             * - - -
             * - B -
             * - - !
             */
            int[][] testCase = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
            assertEquals(2, uniquePaths.uniquePathsWithObstacles(testCase));
        }

        @Test
        public void uniquePathsWithObstacles_TwoBlock1_Success() {
            /*
             * - B -
             * - B -
             * - - !
             */
            int[][] testCase = {{0, 1, 0}, {0, 1, 0}, {0, 0, 0}};
            assertEquals(1, uniquePaths.uniquePathsWithObstacles(testCase));
        }

        @Test
        public void uniquePathsWithObstacles_3x4TwoBlock1_Success() {
            /*
             * - B -
             * - - -
             * - B -
             * - - !
             */
            int[][] testCase = {{0, 1, 0}, {0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
            assertEquals(2, uniquePaths.uniquePathsWithObstacles(testCase));
        }


        @Test
        public void uniquePathsWithObstacles_4x5TwoBlock2_Success() {
            /*
             * - - - -
             * - B - -
             * - - - -
             * - - B -
             * - - - !
             */
            int[][] testCase = {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
            assertEquals(7, uniquePaths.uniquePathsWithObstacles(testCase));
        }

        @Test
        public void uniquePathsWithObstacles_NoSolution_Success() {
            /*
             * B
             */
            int[][] testCase = {{1}};
            assertEquals(0, uniquePaths.uniquePathsWithObstacles(testCase));
        }
    }

}
