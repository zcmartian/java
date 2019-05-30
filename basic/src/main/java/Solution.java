import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

//
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
////        head.next.next = new ListNode(1);
////        head.next.next.next = new ListNode(2);
////        head.next.next.next.next = new ListNode(1);
//        System.out.println(new Solution().isPalindrome(head));

//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(5);
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
//        ListNode l3 = new ListNode(2);
//        l3.next = new ListNode(6);
//        ListNode[] lists = {l1, l2, l3};
//        mergeKLists(lists);

//        new Solution().flatten(root);
        new Solution().flatten2(root);
        System.out.println(root);
    }

    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[s.length()][p.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) != '*')
                break;
            else
                match[s.length()][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    match[i][j] = match[i + 1][j + 1];
                else if (p.charAt(j) == '*')
                    match[i][j] = match[i + 1][j] || match[i][j + 1];
                else
                    match[i][j] = false;
            }
        }
        return match[0][0];
    }

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; ++i) {
            // put返回map对应key的旧值,所以如果两个key相同的put返回同一个索引,若等号两边索引不等则模式匹配失败
            Integer a = (Integer) index.put(pattern.charAt(i), i);
            Integer b = (Integer) index.put(words[i], i);
            if (a != b)
                return false;
        }
        return true;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return ret;

        queue.offer(root);
        boolean left2right = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (left2right) {
                    if (node.left != null)
                        stack.push(node.left);
                    if (node.right != null)
                        stack.push(node.right);
                } else {
                    if (node.right != null)
                        stack.push(node.right);
                    if (node.left != null)
                        stack.push(node.left);
                }
            }
            while (!stack.isEmpty()) {
                queue.offer(stack.pop());
            }
            left2right = !left2right;
            ret.add(level);
        }
        return ret;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, inorder.length - 1, 0, postorder, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart) {
        if (inEnd > inStart) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        if (inEnd == inStart) {
            return root;
        }
        int index = 0;
        // find the index in inorder:
        for (int i = inStart; i >= inEnd; i--) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        root.right = build(inorder, inStart, index + 1, postorder, postStart - 1);
        root.left = build(inorder, index - 1, inEnd, postorder, postStart - (inStart - index) - 1);

        return root;
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> reached = new HashSet<String>();
        if (!wordDict.contains(endWord))
            return 0;
        reached.add(beginWord);
        wordDict.add(endWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0)
                return 0;
            reached = toAdd;
        }
        return distance;
    }

    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while (true) {
            while (i < hi && less(a[++i], a[lo])) ;
            while (j > lo && less(a[lo], a[--j])) ;
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }

    private void shuffle(int a[]) {

        final Random random = new Random();
        for (int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0)
            return 0;

        // dp[i] is the last num for length i increasing sequence
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int len = 1;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > dp[len]) {
                len++;
                dp[len] = nums[i];
            } else {
                int index = lowerBound(dp, 0, len, nums[i]);
                if (dp[index] != nums[i])
                    dp[index] = Math.min(dp[index], nums[i]);
            }

        return len;
    }

    private int lowerBound(int[] arr, int l, int r, int target) {

        int left = l, right = r + 1;
        while (left != right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target)
                right = mid;
            else // arr[mid] < target
                left = mid + 1;
        }
        return left;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        int sLen = s.length();
        int pLen = p.length();
        int[] hash = new int[26];
        List<Integer> pos = new ArrayList<Integer>();

        for (int i = 0; i < pLen; i++) {
            hash[p.charAt(i) - 'a']++;
        }
        int count = 0;

        while (right < sLen) {
            if (hash[s.charAt(right) - 'a'] > 0) {
                hash[s.charAt(right) - 'a']--;
                count++;
                right++;
            } else {
                hash[(int) s.charAt(left) - 'a']++;
                count--;
                left++;
            }

            if (count == pLen) {
                pos.add(left);
            }

        }
        return pos;
    }

    long minDiff = Long.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return (int) minDiff;
    }

    private void helper(TreeNode curr, long lb, long rb) {
        if (curr == null)
            return;
        if (lb != Long.MIN_VALUE) {
            minDiff = Math.min(minDiff, curr.val - lb);
        }
        if (rb != Long.MAX_VALUE) {
            minDiff = Math.min(minDiff, rb - curr.val);
        }
        helper(curr.left, lb, curr.val);
        helper(curr.right, curr.val, rb);
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    public void flatten2(TreeNode root) {
        if(root == null) return;
        flatten2(root.left);
        flatten2(root.right);
        root.left = prev;
        root.right = null;
        prev = root;
    }

    private ListNode reverse(ListNode head) {//翻转链表返回新的头结点
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}