package com.example.eventmanagement;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*public class NoteAdapter extends FirestoreRecyclerNoteAdapter<Note, NoteAdapter.NoteViewHolder> {
    Context context;

    public NoteAdapter(@NonNull FirestoreRecyclerOptions<Note> options, Context context) {
<<<<<<< HEAD
        super(options);
=======
        super();
>>>>>>> a3a39fa (Commit)
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteViewHolder holder, int position, @NonNull Note note) {
        holder.titleTextView.setText(note.title);
        holder.contentTextView.setText(note.content);
        holder.timestampTextView.setText(Utility.timestampToString(note.timestamp));

<<<<<<< HEAD
        holder.itemView.setOnClickListener((v)->{
            Intent intent = new Intent(context, Notes.class);
            intent.putExtra("title",note.title);
            intent.putExtra("content",note.content);
            String docId = this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("docId",docId);
=======
        holder.itemView.setOnClickListener((v) -> {
            Intent intent = new Intent(context, Notes.class);
            intent.putExtra("title", note.title);
            intent.putExtra("content", note.content);
            String docId = this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("docId", docId);
>>>>>>> a3a39fa (Commit)
            context.startActivity(intent);
        });

    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
<<<<<<< HEAD
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_note_adapter,parent,false);
        return new NoteViewHolder(view);
    }

    public void stopListening() {
    }

    public void startListening() {
    }

    public void notifyDataSetChanged() {
    }*/

    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView,contentTextView,timestampTextView;
=======
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_note_adapter, parent, false);
        return new NoteViewHolder(view);
    }*/



    class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, contentTextView, timestampTextView;
>>>>>>> a3a39fa (Commit)

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.note_title_text_view);
            contentTextView = itemView.findViewById(R.id.note_content_text_view);
            timestampTextView = itemView.findViewById(R.id.note_timestamp_text_view);
        }
    }

<<<<<<< HEAD
=======

>>>>>>> a3a39fa (Commit)
