<div id="csidebar">
<ul>
	<?php if ( !function_exists('dynamic_sidebar') || !dynamic_sidebar() ) : ?>
<li id="search">
<?php include (TEMPLATEPATH . '/searchform.php'); ?>
</li>


<li class="widget widget_categories">
<h3>Categories<span>//</span></h3>
 <ul>
<?php wp_list_categories('&title_li='); ?> 
</ul>
</li>




<li class="widget widget_pages">
<h3>Pages<span>//</span></h3>
<ul>
 <?php wp_list_pages('title_li='); ?>
</ul>
</li>




<li class="widget widget_recent_comments">
<h3>Recent Comments<span>//</span></h3>
    <ul>
<?php
global $wpdb;
$sql = "SELECT DISTINCT ID, post_title, post_password, comment_ID,
comment_post_ID, comment_author, comment_date_gmt, comment_approved,
comment_type,comment_author_url,
SUBSTRING(comment_content,1,12) AS com_excerpt
FROM $wpdb->comments
LEFT OUTER JOIN $wpdb->posts ON ($wpdb->comments.comment_post_ID =
$wpdb->posts.ID)
WHERE comment_approved = '1' AND comment_type = '' AND
post_password = ''
ORDER BY comment_date_gmt DESC
LIMIT 6";
$comments = $wpdb->get_results($sql);
$output = $pre_HTML;

foreach ($comments as $comment) {
$output .= "\n<li>"." <a href=\"" . get_permalink($comment->ID) .
"#comment-" . $comment->comment_ID . "\" title=\"on " .
$comment->post_title . "\">" .strip_tags($comment->comment_author)
."</a>"."："  . strip_tags($comment->com_excerpt)
."</li>";
}

$output .= $post_HTML;
echo $output;?>

</ul>
</li>


<li class="widget widget_recent_entries">
 <h3>Recent Posts<span>//</span></h3>
 <ul>
<?php get_archives('postbypost', 5); ?>
</ul>
</li>

<?php /*?>
<li class="widget widget_archive">
 <h3>Archives<span>//&nbsp;存档</span></h3>
 <ul>
<?php wp_get_archives('type=monthly'); ?>
</ul>
 </li>
<?php */?>
 

<li class="widget widget_links">
<h3>Blog roll<span>//</span></h3>
<ul>
	<?php get_links('-1', '<li>', '</li>', '<br />', FALSE, 'id', FALSE, FALSE, -1, FALSE); ?>
</ul>
</li>


	<?php endif; ?>
</ul>
</div>



