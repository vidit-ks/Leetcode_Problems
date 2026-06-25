/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        auto cmp = [](ListNode* a, ListNode* b) {
            return a->val > b->val;
        };

        priority_queue<
            ListNode*,
            vector<ListNode*>,
            decltype(cmp)
        > pq(cmp);

        for (auto x : lists)
            if (x) pq.push(x);

        ListNode dummy(0);
        ListNode* t = &dummy;

        while (!pq.empty()) {
            ListNode* n = pq.top();
            pq.pop();

            t->next = n;
            t = t->next;

            if (n->next)
                pq.push(n->next);
        }

        return dummy.next;
    }
};